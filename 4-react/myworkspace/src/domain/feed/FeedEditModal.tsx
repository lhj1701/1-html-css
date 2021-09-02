import { useRef } from "react";

// { 함수속성 }
// 함수속성의 타입: (매개변수타입) => 리턴타입
// 함수(ex. 부모state제어)를 부모 컴포넌트로 부터 매개변수(prop)를 받음
// 자식컴포넌트에서 이벤트가 발생하면 prop으로 받은 함수를 실행

interface FeedState {
  id : number;
  story? : string | undefined;
  dataUrl? : string | undefined;
  username? : string | undefined;
  creatTime : number;
  userImage? : string | undefined;
  }

interface ModalProp{
  editItem : FeedState;
  onClose:() => void;// 콜백함수
  onSave: (editItem: FeedState) => void; // 콜백함수
}

const FeedEditModal =
({editItem, onClose, onSave} :ModalProp) => {
  const editInputRef = useRef<HTMLInputElement>(null);
  const editTxtRef = useRef<HTMLTextAreaElement>(null);
  const editSave = () => {
    if (editInputRef.current?.files?.length){
      const editFile = editInputRef.current?.files[0];
      const reader = new FileReader();
      // read하라고 실행한것
    reader.readAsDataURL(editFile);
       
      // 로딩이 끝났을 때 처리될 함수를 선언
         reader.onload = () => {
          const editFeed: FeedState = {
            id: editItem.id,
            story : editTxtRef.current?.value,
            userImage : editItem.userImage,
            username : editItem.username,
            dataUrl : editInputRef.current?.value,
            creatTime : new Date().getTime(),
          };
       return onSave(editFeed);
    } 
  };
  };
  
  return (
    <div className="modal d-block"
    style={{ backgroundColor: "rgba(0, 0, 0, 0.5)"}}
    onClick={()=>{onClose();}}>
  <div className="modal-dialog">
    <div className="modal-content"onClick={(e) => e.stopPropagation()}>
      <div className="modal-header">
        <h5 className="modal-title">EDIT Feed</h5>
        <button type="button" className="btn-close" aria-label="Close"
        onClick={()=>{onClose();}}/>
      </div>
      <div className="modal-body">
        
        <textarea
        className="w-100"
        defaultValue={editItem.story}
        ref={editTxtRef}/>
        <input type="file"
        className="w-100"
        accept="image/png, image/jpeg, video/mp4"
        ref = {editInputRef}
        defaultValue={editItem.dataUrl}/>
     </div>
      <div className="modal-footer">
        <button type="button"
        className="btn btn-secondary"
        onClick={()=>{onClose();}}>
        닫기</button>
        <button
        type="button"
        className="btn btn-primary"
        onClick={() => {editSave();}}>
        저장</button>
      </div>
    </div>
  </div>
</div>
)}

export default FeedEditModal