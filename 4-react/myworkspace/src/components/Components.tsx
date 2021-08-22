import Header from "./Header"
import Button from "./Button";

const Components = () => {
  return <div>
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
  </div>
};
export default Components;