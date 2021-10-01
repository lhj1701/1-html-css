import { createSlice, PayloadAction } from "@reduxjs/toolkit"

export interface ContactItem {
  id : number;
  no? : number;
  name : string | undefined;
  phone : string| undefined;
  email : string| undefined;
  memo : string| undefined;
  createdTime :  number ;
}

export interface ContactPage{
  data: ContactItem[];
  totalElments : number;
  totalPages : number;
  page:number;
  pageSize: number;
  isLast:boolean;
}

// 백엔드 연동 고려해서 state 구조를 설계
interface ContactState {
  data : ContactItem[]; // 컨택트아이템 배열
  isFetched : boolean; // 서버에서 데이터를 받아왔는지에 대한 여부
  isAddCompleted?: boolean; // 데이터 추가가 완료되었는지 여부
  isRemoveCompleted?: boolean; // 데이터 삭제가 완료되었는지 여부
  isModifyCompleted?: boolean; // 데이터 수정 완료되었는지 여부
  totalElments? : number;
  totalPages : number;
  page:number;
  pageSize:number;
  isLast?:boolean;
}

const contactPageSize= localStorage.getItem("contact_page_size");
const initialState : ContactState = {
  data : [
    // {id : 1, name : "이효정", tel : "01084855998", mail : "gywjd1701@gmail.com", memo : "삐빅 본인입니다", createTime : 0}
  ],
  isFetched : false,
  page:0,
  pageSize:contactPageSize? +contactPageSize : 2,
  totalPages : 0,
}

const contactSlice = createSlice({
  name : "contact",
  initialState,
  reducers : {
    addContact : (state, action : PayloadAction<ContactItem>) => {
      const contact = action.payload;
      state.data.unshift(contact);
      state.isAddCompleted = true; // 추가되었음으로 표시
  },
  // payload 없는 reducer - completed 관련 속성을 삭제함
  initialCompleted : (state) => {
    delete state.isAddCompleted;
    delete state.isRemoveCompleted;
    delete state.isModifyCompleted;
  },
  removeContact : (state, action : PayloadAction<number>) => {
    const id = action.payload;
    // 아이디에 해당하는 아이템의 인덱스를 찾고, 그 인덱스로 스플라이스를 한다
    state.data.splice(
      state.data.findIndex((item)=>item.id===id), 1
    );
    state.isRemoveCompleted = true; // 삭제되었음을 표시
  },
   modifyContact : (state, action : PayloadAction<ContactItem>) => {
          const modifyItem = action.payload; // 생성해서 넘긴 객체
          const contactItem = state.data.find((item)=>item.id === modifyItem.id);// state에 있는 애
          
          // state에 있는 객체의 속성을 넘김 객체의 속성으로 변경
          if (contactItem) {
            contactItem.no = modifyItem.no;
            contactItem.name = modifyItem.name;
            contactItem.phone = modifyItem.phone;
            contactItem.email = modifyItem.email;
            contactItem.memo = modifyItem.memo;
            contactItem.createdTime = modifyItem.createdTime;
          }
              },
    // payload값으로 state를 초기화하는 reducer 필요함
    initialContact:(state, action:PayloadAction<ContactItem[]>)=>{
      const contacts = action.payload;
      // 백엔드에서 받아온 데이터
      state.data=contacts;
      // 데이터를 받아옴으로 값을 남김
      state.isFetched=true;
    },
    // payload값으로 state를 초기화하는 reducer 필요함
    initialPagedContact:(state, action:PayloadAction<ContactPage>)=>{
     // 백엔드에서 받아온 데이터
     state.data = action.payload.data; //컨텐트
     state.totalElments = action.payload.totalElments; //페이징데이터
     state.totalPages = action.payload.totalPages;
     state.page = action.payload.page;
     state.pageSize = action.payload.pageSize;
     state.isLast = action.payload.isLast;
      // 데이터를 받아옴으로 값을 남김
      state.isFetched=true;
    }
  }
})
export const {addContact, removeContact, modifyContact, initialContact, initialCompleted, initialPagedContact} = contactSlice.actions;
export default contactSlice.reducer;