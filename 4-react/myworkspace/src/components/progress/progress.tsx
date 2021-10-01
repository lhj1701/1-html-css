import { useSelector } from "react-redux";
import { Rootstate } from "../../store";

const Progress = () => {
  const progress = useSelector((state:Rootstate)=>state.progress);
  return (
<>
{/* position: fixed, 너비값은 컨텐츠너비, 높이값은 자식 높이*/}
{/* spinner, progress 이런것들은 사용자의 입력 방지 */}
{progress.status &&(<div className="position-fixed" style={{width: "100%", height:"100%", left:0, top:0,zIndex:9000}}>
<div className="spinner-border text-info position-fixed" role="status" style={{left:"50%",top:"50%",zIndex:9000}}>
  <span className="visually-hidden">Loading...</span>
  </div>
  </div>)}
  </>
  );
};
export default Progress;