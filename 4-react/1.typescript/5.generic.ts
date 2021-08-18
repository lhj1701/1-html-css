//(타입 매개변수)제너릭, 제네릭, 쥐네릭 : 다양한 타입에 따라서 실행처리를 다르게 하기 위함

function identity<Type>(arg:Type):Type{
  // 타입에 따라서 내부 코드를 분기함
  // 예) number면 숫자를 덧셈함
  // 예) string면 문자열을 구분자로 결함
  
  return arg;
}

let output1 = identity<string>("TypeScript");
let output2 = identity<number>(1);
