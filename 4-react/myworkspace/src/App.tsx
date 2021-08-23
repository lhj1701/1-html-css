// https://react.vlpt.us/styling/02-css-module.html
// css module
// 파일명.module.css
// css를 사용하는 컴포넌트 범위로 css class 사용범위를 좁힐 수 있음.
import { Component } from 'react';
import './App.scss';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import { Suspense, lazy } from 'react';
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

// spa (single page application) : 페이지 파일이 1개, index.html
// 특정 영역(switch)에 컴포넌트(js)를 로딩함
// 앱이 컴파일될 때 import한 컴포넌트가 같이 컴파일 됨
// lazy-loading : 컴포넌트를 방문할때 로딩해옴
import Home from './components/Home';
import Navigation from './components/Navigation';

const Counter = lazy(()=>import("./components/Counter") )
const Calculator = lazy(()=>import("./components/CalculatorRef"))
const Generator = lazy(()=>import('./components/Generator'))
const Hello = lazy(()=>import( "./components/Hello"))
const AccountManager = lazy(()=>import ('./components/AccountManagerRef'))
const Components = lazy(()=>import('./components/Components'))
const Bootstrap = lazy(()=>import ('./components/Bootstrap'))
const Todo = lazy(()=>import ('./components/Todo'))



// 리액트 == 컴포넌트 개발 라이브러리

function App() {
  return (
    <Router>

    <div style={{width:"700px"}} className="mx-auto">
      <nav style={{width:"200px", height:"100vh", top:"20px"}} className="position-fixed">
        <Navigation/>
      </nav>
      <main style={{marginLeft:"200px", marginTop:"20px"}}>
        {/* suspense : 컴포넌트 로딩 중에 보여줄 화면을 처리
        fallback{로딩 중에 보여줄 문구} */}
        <Suspense fallback={<div>Loading...</div>}>
        <Switch>
          {/* switch 영역에 컴포넌트가 로딩됨 */}
           {/* 해당 경로에 대해서 로딩할 컴포넌트 목록을 작성 */}
          <Route path="/" component={Home} exact/>
          <Route path="/components" component={Components}/>
          <Route path="/counter" component={Counter}/>
          <Route path="/calculator" component={Calculator}/>
          <Route path="/generator" component={Generator}/>
          <Route path="/account-manager" component={AccountManager}/>
          <Route path="/bootstrap" component={Bootstrap}/>
          <Route path="/todo" component={Todo}/>
        </Switch>
        </Suspense>
      </main>

      {/* 재사용하지 않는 컴포넌트 */}
      {/* 속성값을 변경하여 재사용하는 컴포넌트 */}
      {/* component의 속성(prop)을 넘김*/}
      {/* 속성명={속성값}*/}
{/* <Counter/>
<Generator/>
<Calculator/>
<AccountManager/>
<Hello/> */}
    </div></Router>
  );
}
// App.tsx 모듈의 기본 내보내기를 App 함수로 함

export default App;
