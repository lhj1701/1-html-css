// calculator 컴포넌트

import { useState } from "react";

// 1. prompt로 입력값을 두번 받음
// a = prompt, b =prompt

// 2. 연산자를 prompt로 받음
// +, -, *, /

// 3. 입력값 두개에 대한 연산 결과를 화면출력
// state를 사용해야함

// 예) 입력값 1 : 10 넣음
// 입력값 2: 5 넣음
// 연산자 *
// 결과값 : 50 
// <div>50</div>

const calculator = () => {

const [result, setResult] = useState(0);
const calcuate = () => {
const a = prompt("첫번째 숫자")
const b = prompt("두번째 숫자")
const op = prompt("연산자,(+,-,*,/)")

console.log(`${a}${op}${b}`);
setResult(eval(`${a}${op}${b}`));

//eval(문자열)
//문자열이 자바스크립트코드로 실행될 수 있다면 실행함
const code = `alert(${a}${op}${b})`

// state 값에 변동이 없으면 컴포넌트를 업데이트하지 않음
// 기존 result == 20
// 변동 result == 20, 컴포넌트를 업데이트하지 않음

eval("alert('')")
};

  return(
    <div>
      <h2 onClick={()=>{
        calcuate();
      }}
      >calculator</h2>
    <button>start</button>
    <div>{result}</div>
    </div>
  ) 
}
export default calculator
