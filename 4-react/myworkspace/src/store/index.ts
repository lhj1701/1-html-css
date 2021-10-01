// global state(전역상태) 저장소 만듦
// global state : profile, todo, contact...여러개 state가 있음
// 이러한 state 들은 다른 컴포넌트와 state가 공유됨
import { configureStore } from "@reduxjs/toolkit";
import profileReducer from "../features/profile/profileSlice_이효정"
import photoReducer from "../features/photo/photoSlice"
import contactReducer from "../features/contact/contactSlice";
import progressRecucer from "../components/progress/progressSlice";
import alertReducer from "../components/alert/alertSlice";

//최상위 사가
import rootSaga from "../saga";
import createSagaMiddleware from "@redux-saga/core";

// saga middleware생성
// middleware : 중간에 뭔가를 처리하는 소프트웨어
// redux saga : redux 상태처리 전/후에 뭔가를 해주는 라이브러리
const sagaMiddleware = createSagaMiddleware();

export const store = configureStore({
  // 각 state 별로 처리할 reducer 목록
  reducer : {
    profile : profileReducer,  // profile state 처리하는 reducer를 등록
    photo : photoReducer, // photo state 처리하는 reducer를 등록
    contact : contactReducer,
    progress : progressRecucer,
    alert : alertReducer,
}, 
// redux store(dispatcher)에 미들웨어 적용
// middleware는 여러 개 사용할 수 있음, [defaultMiddleware, sagaMiddleware, thunkMiddleware]
middleware:[sagaMiddleware], 
  devTools : true, // 개발툴 사용여부
});

//리덕스 : 컴포넌트->디스패치(리덕스액션)->디스패쳐->리듀서->스토어/스테이트

//리덕스사가 : 컴포넌트->디스패치(사가액션)->디스패쳐->사가->api-> put(reduxAction) ->리듀서->스토어/스테이트

//saga middleware를 실행
//rootSaga와 하위에 정의한 감지(take)할 Saga Action들에 대해서 감지 시작
sagaMiddleware.run(rootSaga);

// typescript에서는 몇가지 타입 선언을 해야함

// root state 타입 정의
// 가장 최상위 state
// state.contact...
export type Rootstate=ReturnType<typeof store.getState>;

// dispatch 타입 정의
// dispatch 함수의 generic type
export type AppDispatch = typeof store.dispatch;
