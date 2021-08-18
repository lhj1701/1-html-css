// 타입추론

// 첫번째 대입값에 따라서 형식을 자동으로 지정함
let firstname = "John"; // let firstnmae : string = "John"
console.log(firstname.toUpperCase());

// firstname=1; 타입에러
// 첫번째 글자를 대문자로 변환하는 함수
function capitalize1(str:string){
  //toUpperCase() : string
  //substr(..) : string
  //string+string ===string

  //return string
    return str[0].toUpperCase()+str.substr(1);
  }
  
  console.log(capitalize1("javascript"));