// 컴포넌트 정의
// 리액트 컴포넌트 = JSX를 반환하는 함수
// <></>: Fragment (조각) 어떤 태그형식으로 변환되지 않음, 빈 태그

import { title } from "process";

// 컴포넌트에 속성으로 컬러, 타이틀을 받을 것
// 컴포넌트의 속성(prop): 함수의 매개변수처럼 외부에서 넘겨받는 변수

interface HeaderProp{
  // color : string;
  // union type : 값의 집합
  color : "green" | "red" | "blue"
  variant : "primary" | "secondary";
  title : string;
}

// fc = function component
// const 함수명 : React.Fc<속성타입> = ({속성1, 속성2})=> {
// ...}
const Header = ({color, tilte}:any)=>{
  // main container
  return<h1 style={{color:color}}>{title}</h1>
  // 여러개의 부모 엘리먼트를 반환하지 못함

}

// 컴포넌트 내보내기
export default Header;