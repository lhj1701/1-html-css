import contactReducer, { addContact, ContactPage, initialContact, initialPagedContact, modifyContact, removeContact } from "./contactSlice"
import { AxiosResponse } from "axios";

//----------saga action 생성하는 부분--------------

import { createAction, nanoid, PayloadAction } from "@reduxjs/toolkit";
import { ContactItem } from "./contactSlice";
import { call, put, select, takeEvery, takeLatest } from "@redux-saga/core/effects";
import contactApi,{ ContactItemRequest, ContactItemResponse, ContactPagingResponse } from "./contactApi";
import { endProgress, startProgress } from "../../components/progress/progressSlice";
import { initialCompleted } from "./contactSlice";
import { addAlert } from "../../components/alert/alertSlice";
import { Rootstate } from "../../store";

// contact를 추가하도록 요청하는 action
// {type: string, payload:ContactItem}
// {type: "contact/requestAddContact", payload:{name, phone, mail...}}

//---------action creator 실행
// const item : contactItem = {name, phone, mail...}
// const sagaAction = requestAddContact(item)

// ---------생성된 action 객체
// sagaAction > {type: "contact/requestAddContact", payload:{name, phone, mail...}}

// contact를 추가하도록 요청하는 action creator를 생성
// createAction<Payload타입>(Action.type)
export const requestAddContact = createAction<ContactItem>(
`${contactReducer.name}/requestAddContact`
);

// contact를 가져오는 action
export const requestFetchContacts = createAction(
  `${contactReducer.name}/requestFetchContacts`  
)

// contact를 paging으로 가져오는 action
export interface PageRequest{
  page : number,
  size : number,
}
export const requestFetchPagingContacts = createAction<PageRequest>(
  `${contactReducer.name}/requestFetchPagingContacts`  
)

// 삭제 action
export const requestRemoveContact = createAction<number>(
  `${contactReducer.name}/requestRemoveContact`  
);

// 수정 action
export const requestModifyContact = createAction<ContactItem>(
  `${contactReducer.name}/requestModifyContact`  
)

// ---------------saga action 처리하는 부분
// 서버에 POST로 데이터를 보내 추가하고, redux state를 변경
function* addData(action:PayloadAction<ContactItem>){
  yield console.log("--addData--");
  yield console.log(action);

  try{
//action의 payload로 넘어온 객체
const contactItemPayload = action.payload;

//rest api로 보낼 요청 객체
const contactItemRequest : ContactItemRequest = {
  name : contactItemPayload.name,
  phone : contactItemPayload.phone,
  email : contactItemPayload.email,
  memo : contactItemPayload.memo,
};

//----1.rest api에 post로 데이터 보냄
//call(비동기함수, 매개변수1,매개변수2...)-> 함수를 호출함
//spinner 보여주기
yield put(startProgress());

//함수가 Promise를 반환하면, (비동기함수)
//saga middleware에서 현재 yield에 대기 상태로 있음
//promise가 resolve(처리완료)되면 다음 yield로 처리 진행, reject되면 예외를 던짐(throw)->try...catch문으로 받을 수 있음

//await api.add(contactItemRequest)와 일치, 결과값 형식을 지정해야함
const result : AxiosResponse<ContactItemResponse> = yield call(
  contactApi.add
  ,contactItemRequest
  );

  //spinner 사라지게 하기
yield put(endProgress());

//-----2.redux state를 변경
 // **210928 페이징 처리 추가 로직**
 // 추가하기 전에 현재 페이지의 가장 마지막 데이터를 삭제
 // redux state 조회하기
const contactData: ContactItem[] = yield select((state:Rootstate)=>state.contact.data)
 // 현재 데이터가 있으면
if(contactData.length>0){
  //가장 마지막 요소의 아이디값을 가져옴
  const deleteId = contactData[contactData.length-1].id
  yield put(removeContact(deleteId));
}
// 백엔드에서 처리한 데이터 객체로 state를 변경할 payload객체를 생성
  const contactItem:ContactItem={
    id:result.data.id,
    name : result.data.name,
    phone : result.data.phone,
    email : result.data.email,
    memo : result.data.memo,
    createdTime : result.data.createdTime,
  };
  // dispatcher(액션)보내는 것도 동일함
  // useDispatch로 dispatcher 만든 것은 컴포넌트에서만 가능
  // put 이펙트를 사용함
  yield put(addContact(contactItem))

  // completed 속성 삭제
  yield put(initialCompleted());
  }
  catch(e:any){
    // 에러 발생 -> 얼럿 추가
    yield put(addAlert({id:nanoid(),variant:"danger",message:e.message}))
  }

  
}
// 서버에서 get으로 데이터를 가져오고, redux state를 초기화
function* fetchData(){
yield console.log("--fetchdata--")

//spinner 보여주기
yield put(startProgress());

const result : AxiosResponse<ContactItemResponse[]>=yield call(contactApi.fetch);
//ContactItemResponse[] -> ContactIteme[] 로 변환해야함 (응답데이터배열을 액션페이로드 배열로 변환)

//spinner 사라지게 하기
yield put(endProgress());

const contacts = result.data.map((item)=>({
id : item.id,
name : item.name,
phone : item.phone,
email : item.email,
memo : item.memo,
createdTime : item.createdTime,
} as ContactItem)
);
yield put(initialContact(contacts))
}

function* fetchPagingData(action:PayloadAction<PageRequest>){
  yield console.log("--fetchPagingData--")

  const page = action.payload.page;
  const size = action.payload.size;

  localStorage.setItem("contact_page_size",size.toString());
//spinner 보여주기
yield put(startProgress());

try{
const result : AxiosResponse<ContactPagingResponse>=yield call(contactApi.fetchPaging, page, size);
//ContactItemResponse[] -> ContactIteme[] 로 변환해야함 (응답데이터배열을 액션페이로드 배열로 변환)

//spinner 사라지게 하기
yield put(endProgress());

const contacts = result.data.content.map((item)=>({
id : item.id,
name : item.name,
phone : item.phone,
email : item.email,
memo : item.memo,
createdTime : item.createdTime,
} as ContactItem)
);

const contactPage : ContactPage ={
  data : contacts,
  totalElments : result.data.totalElements,
  totalPages : result.data.totalPages,
  page:result.data.number,
  pageSize:result.data.number,
  isLast:result.data.last,
}
yield put(initialPagedContact(contactPage))
 }catch(e:any){
      // 에러발생
  //spinner 사라지게 하기
  yield put(endProgress());
  
  // 얼럿박스를 추가해줌
  yield put(addAlert({id:nanoid(),variant:"danger",message : e.message}))
 }
 }

function* removeData(action:PayloadAction<number>){
  yield console.log("--removedata--");
  // id 값
  const id = action.payload;

  //spinner 보여주기
  yield put(startProgress());

  // rest api 연동
  const result:AxiosResponse<boolean> = yield call(contactApi.remove,id);

   //spinner 사라지게 하기
  yield put(endProgress());

  // 반환값이 true면
  if (result.data){
    yield put(removeContact(id));
  }

  //completed 속성 삭제
  yield put(initialCompleted());
  // 현재 페이지 데이터를 다시 가져옴
  // 현재 ㄴ페이지와 사이즈 값을 읽어옴
  const page : number = yield select ((state:Rootstate)=>state.photo.page)
  const size : number = yield select ((state:Rootstate)=>state.photo.pageSize)
  yield put(requestFetchPagingContacts({page, size}))
}

function* modifyData(action:PayloadAction<ContactItem>){
  yield console.log("--modifyData--");
 //action의 payload로 넘어온 객체
 const contactItemPayload = action.payload;

 //rest api로 보낼 요청 객체
 const contactItemRequest : ContactItemRequest = {
   name : contactItemPayload.name,
    phone : contactItemPayload.phone,
    email : contactItemPayload.email,
    memo : contactItemPayload.memo,
 };

 //spinner 보여주기
 yield put(startProgress());

 const result : AxiosResponse<ContactItemResponse> = yield call(
   contactApi.modify,
   contactItemPayload.id,
   contactItemRequest
 )
    //spinner 사라지게 하기
    yield put(endProgress());

    //redux state 변경 : 백엔드에서 처리한 데이터 객체로 state를 변경할 payload객체를 생성
    const contactItem:ContactItem={
      id:result.data.id,
      name : result.data.name,
      phone : result.data.phone,
      email : result.data.email,
      memo : result.data.memo,
      createdTime : result.data.createdTime,
    };

    yield put(modifyContact(contactItem));

    //completed 속성 삭제
  yield put(initialCompleted());
}
// ---------------saga action 감지하는 부분
// contact redux state처리와 관련된 saga action들을 감지(take)할 saga를 생성
// saga는 generator 함수로 작성
export default function* contactSaga(){
  // dispatcher 동일 타입의 액션은 모두 처리함
  yield takeEvery(requestAddContact, addData);// takeEvery(처리할 액션, 액션을 처리할 함수)
  yield takeLatest(requestFetchPagingContacts, fetchPagingData);
  yield takeLatest(requestFetchContacts,fetchData); // 동일한 타입의 액션 중 가장 마지막 액션만 처리, 이전 액션은 취소
  yield takeEvery(requestRemoveContact, removeData);
  yield takeEvery(requestModifyContact, modifyData);
  
}