// global state(전역상태) 저장소 만듦
// global state : profile, todo, contact...여러개 state가 있음
// 이러한 state 들은 다른 컴포넌트와 state가 공유됨
import { configureStore } from "@reduxjs/toolkit";
import profileReducer from "../domain/profile/profileSlice_이효정"
import photoReducer from "../domain/Photo/photoSlice"

export const store = configureStore({
  // 각 state 별로 처리할 reducer 목록
  reducer : {
    profile : profileReducer,  // profile state 처리하는 reducer를 등록
    photo : photoReducer // photo state 처리하는 reducer를 등록
}, 
  devTools : true, // 개발툴 사용여부
});

// typescript에서는 몇가지 타입 선언을 해야함

// root state 타입 정의
// 가장 최상위 state
// state.contact...
export type Rootstate=ReturnType<typeof store.getState>;

// dispatch 타입 정의
// dispatch 함수의 generic type
export type AppDispatch = typeof store.dispatch;
