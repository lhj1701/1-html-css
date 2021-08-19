import React from 'react';
import logo from './logo.svg';
import './App.css';
import calculator from './components/calculator';
import Generator from './components/generator';
// JSX : Javascript 기반의 HTML 태그 형식
// 각각의 태그들(element)은 javascript 객체임
// 일반적인 html 태그 표기법과 다름

// JSX Element
// cosnt element = (
//   <h1 className="greeting">
//     Hello, world!
//     </h1>
// );

// 실제 컴파일되는 결과
// cosnt element = React.createElement(
  // 'h1',
  // {className:'greeting'}, // 속성
  // 'Hello, world!' // 컨텐트
  // );

// document.creatElement("div")
// 실제 DOM을 생성함

// React.createElement("div",...)
// 가상 DOM을 생성함
// 가상 DOM == javascript 객체
// 내부적으로 가상 DOM tree를 관리함

// 가상 DOM을 생성하고 화면그리기(rendering) 시점(event loop)에 가상 DOM을 HTML DOM으로 그림

// 일반 DOM : 돔을 조작할때마다 rendering 함, 성능 저하

// 가상 DOM : 렌더링 주기에 따라서 변동사항만 렌더링함, 성능향상

//----------------------------------------------------------
// react 관련 자료는 2020년 이후 것으로만
// Function Component
// 대문자로 시작함
// JSX Element를 반환
// JS 함수인데, JSX Element를 반환함 == Component
// 리액트에서 컴포넌트는 JSX Element를 렌더링하는 함수
//=> 리액트에서 컴포넌트란? 자바스크립트 기반의 html 태그형식을 화면에 표시해주는 함수

import Header from "./components/Header"
import Button from "./components/Button";
import Counter from "./components/counter";

// 리액트 == 컴포넌트 개발 라이브러리

function App() {
  return (
    // main container
    <div style={{width:"500px", margin:"0 auto"}}>
      {/* JSX 내부에서 주석달기 */}
      {/* 재사용하지 않는 컴포넌트 */}

      <h1 style={{color:"red"}}></h1>

      {/* 속성값을 변경하여 재사용하는 컴포넌트 */}
      {/* component의 속성(prop)을 넘김*/}
      {/* 속성명={속성값}*/}

      <Header color = {"red"} title={"react"}/>
      <Header color = {"green"} title={"javascript"}/>
      <Header color = {"blue"} title={"typescript"}/>

<Button color = {"white"} backgroundColor = {"blue"} text={"Add"}/>
<Button color = {"black"} backgroundColor = {"red"} text={"delete"}/>
<Button color = {"white"} backgroundColor = {"green"} text={"done"}/>
<Counter/>

    </div>
  );
}
// App.tsx 모듈의 기본 내보내기를 App 함수로 함

export default App;
