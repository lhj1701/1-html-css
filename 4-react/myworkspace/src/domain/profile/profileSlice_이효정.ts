import { createSlice, PayloadAction } from "@reduxjs/toolkit"
import { penguin } from "../../common/data";

// 리덕스 저장소(상태저장소)에 하나의 state(조각)를 슬라이스라고 함
// 관리하고 처리할 수 있는 모듈

// slice 에는 state와 reducer가 있음
// reducer는 state를 변경하는 함수

// state 타입 선언
interface ProfileState {
  userImage: string | undefined;
  username: string | undefined;
}

// state 초기상태 선언
const initialState : ProfileState = {
userImage : penguin,
username : " lhj"
};


// slice 생성
export const profileSlice = createSlice({
  name : "profile", // slice(state)의 이름
  // initialState: initialState, // state의 초기값
  initialState, // state의 초기값 (객체명과 내용이 같아서 한 번만 사용해도 됨)
  
  // 리듀서 : state변경 함수 목록
  reducers: {
    // 함수명 : (기존 state변수명, action변수명) => {state 변경처리}
    saveProfile : (state, action: PayloadAction<ProfileState>) =>{
    //immer가 내장되어있음ㅇㅇ 따라서 state 변수를 직접 제어함
    const profile = action.payload; // 매개변수로 받은 데이터
    state.userImage = profile.userImage;
    state.username=profile.username;
},
  },
});

// action creator 내보내기 -> 컴포넌트에서 사용하기 위함
// reducer 함수명에 맞는 action creator들을 createslice할 때 자동으로 생성
export const {saveProfile} = profileSlice.actions;

// action = {type:"...", payload:{...}}
// action.type:처리할 액션의 종류를 나타내는 문자열
// action.payload: 처리할 데이터

// action creator는 action 객체를 생성하는 함수
// saveProfile(payload)=>{type:"profile/saveProfile", payload}

// slice.reducer == state 변경함수(reducer) 여러 개를 가지고 있는 객체
// slice.reducer : {function..(), function..(),...}

// 내보내기의 기본 객체를 reducer함
export default profileSlice.reducer;
