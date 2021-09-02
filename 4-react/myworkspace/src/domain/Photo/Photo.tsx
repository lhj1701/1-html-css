import { useSelector } from "react-redux";
import { useHistory } from "react-router-dom";
import { Rootstate } from "../../store";

const Photo = () => {
  // photo state 전체를 가져옴
  const photo = useSelector((state:Rootstate)=>state.photo);
  const history = useHistory(); // 컴포넌트 이동을 코드로 제어할 수 있음
return (
<div>
  <h2 className = "text-center">Photos</h2>
  <div className = "d-flex justify-content-end mb-2"><button className="btn btn-primary" onClick={()=>{
    history.push("/photos/")
  }}>
    <i className="bi bi-plus me-1"/>추가</button></div>
  <div className="d-flex flex-wrap">
    {/* state 데이터 배열에 map 함수로 출력 */}
    {photo.data.map((item,index)=>(
      <div className="card" key={`photo-item-${index}`}
      style={{width:"calc(100% - 3rem)/4", marginLeft: index % 4 == 0 ? "0" : "1rem", marginTop : index > 3 ? "1rem" : "0"}}>
        <div className= "card-header">
          <img width={24} height={16}src={item.profileUrl} alt={item.username}/>
          <span>{item.username}</span>
        </div>
      <img src={item.photoUrl} className="card-img-top" alt={item.title}/>
      <div className="card-body">
        <h5 className="card-title">{item.title}</h5>
      </div>
    </div>
    ))}
    <div>

    </div>
  </div>
</div>
)}
export default Photo;