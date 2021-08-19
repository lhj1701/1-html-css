// Button 컴포넌트 생성
// <button...JSX 엘리먼트를 반환하는 컴포넌트

import React from "react";
// 속성:
// color(글자색 "white", "black")
// backgroundColor(배경색"red","green","blue")
// text: 버튼의 텍스트(대문자로 표시)

// variant : 버튼 스타일 타입

interface ButtonProp{
  color : "white" | "black",
  backgroundColor : "red" | "green" | "blue",
  // variant : "primary" | "seconadry" | "wanring"
  text : string,
}

const Button : React.FC<ButtonProp> = ({color, backgroundColor, text}) => {
  return <button style={{color:color, backgroundColor : backgroundColor}}>
    {text.toUpperCase()}</button>;
}



export default Button


















