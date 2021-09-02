import { useRef } from "react";
import { useHistory } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { AppDispatch, Rootstate } from "../../store";
import { addPhoto, PhotoItem} from "./photoSlice";

const PhotoCreate = () => {
  // 입력 폼 ref 객체
  const title = useRef<HTMLInputElement>(null);
  const desc = useRef<HTMLTextAreaElement>(null);
  const file = useRef<HTMLInputElement>(null);

  // 포토데이터 배열가져오기
  const photoData = useSelector((state:Rootstate)=>state.photo.data);
  // 프로필 정보 가져오기
  const profile = useSelector((state:Rootstate)=>state.profile);

  const dispatch = useDispatch<AppDispatch>();

  // history 객체 가져오기
  const history = useHistory();

  const handleAddClick = () => {
    if(file.current?.files?.length){
      const imageFile = file.current.files[0];
      const reader = new FileReader();
      reader.onload = () => {
        // 추가할 객체 생성
        const item : PhotoItem = {
          // 기존 데이터의 id 중에서 가장 큰 것
          id : photoData.length ? photoData[0].id + 1 : 1,
          // 프로필 정보
          profileUrl : profile.userImage ? profile.userImage : "", 
          username : profile.username ? profile.username : "",
          // 입력정보
          title : title.current? title.current.value : "",
          description : desc.current?.value,
          photoUrl : reader.result? reader.result.toString() : "",
          // 시스템값(작성일시, 수정일시, 수정한 사람)
          createTime : new Date().getTime(),
        }
          
          // 디스패쳐 생성하기

          // 1. addPhoto함수에서 action 객체 생성-> {type: "photo/addPhoto", payload:item}
          // 2. action 객체를 dispatcher에 전달함
          // 3. 디스패쳐에 action.type에 맞는 리듀서 함수를 실행  -> 기존 스테이트와 페이로드를 매개변수로 넣어주고 실행

          dispatch(addPhoto(item));
        }
        reader.readAsDataURL(imageFile)
      }
    }

  return (<div style={{width:"40vw"}} className="mx-auto">
    <h2 className= "text-center">Photos Create</h2>{""}
    <form>
      <table className="table">
        <tbody>
          <tr><th>제목</th><td><input className="form-control" type="text" ref={title} /></td></tr>
          <tr><th>설명</th><td><textarea className="form-control" style={{height:"40vh"}} ref={desc}></textarea></td></tr>
          <tr><th>이미지</th><td><input className="form-control" type="file" accept="image/*" ref={file}/></td></tr>
        </tbody>
      </table>
    </form>
    <div><button
          className="btn btn-secondary float-start"
          onClick={() => {
            history.push("/photos");
          }}
        >
          <i className="bi bi-grid-3x3-gap me-1"></i>
          목록
        </button>
        <button
          className="btn btn-primary float-end"
          onClick={() => {
            handleAddClick();
          }}
        >
          <i className="bi bi-check" />
          저장
        </button>
      </div>
    </div>
  );
};

  export default PhotoCreate;