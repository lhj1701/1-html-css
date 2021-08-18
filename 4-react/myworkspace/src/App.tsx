import React from 'react';
import logo from './logo.svg';
import './App.css';

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

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}
// App.tsx 모듈의 기본 내보내기를 App 함수로 함

export default App;
