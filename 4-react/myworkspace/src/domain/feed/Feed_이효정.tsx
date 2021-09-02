import { useRef, useState } from "react";
import produce from "immer";
import FeedEditModal from "./FeedEditModal";
import { useSelector } from "react-redux";
import { Rootstate } from "../../store";
import style from "./Feed.module.scss";

const getTimeString = (unixtime: number) => {
  const dateTime = new Date(unixtime);
  return `${dateTime.toLocaleDateString()} ${dateTime.toLocaleTimeString()}`;
};

interface FeedState {
  id : number;
  story? : string | undefined;
  dataUrl? : string | undefined;
  username? : string | undefined;
  creatTime : number;
  userImage? : string | undefined;
  }

const Feed = () => {
  const profile = useSelector((state:Rootstate)=>state.profile)
  const [feedList,setFeedList] = useState<FeedState[]>([
  ]);

  
// {함수속성}
// 함수속성의 타입 : (매개변수타입) => 리턴타입
// 함수(ex.부모state제어)를 부모컴포넌트로부터 매개변수(prop)를 받음
// 자식컴포넌트에서 이벤트가 발생하면 prop으로 받은 함수를 실행


  // 수정팝업을 띄울지 아닐지
  const [isEdit,setIsEdit] = useState(false);
  // * isEdit state 가 true일때만 modal 창이 보임 */
  
  const inputRef = useRef<HTMLInputElement>(null);
  const txtRef = useRef<HTMLTextAreaElement>(null);
  const formRef = useRef<HTMLFormElement>(null);

  const add = () => {
     // files가 있어도 선택을 안하면 length 0
     if (inputRef.current?.files?.length){ // 파일에 대입함 
    const file = inputRef.current?.files[0];
    const reader = new FileReader();

    // read하라고 실행한것
    reader.readAsDataURL(file);
     
    // 파일 로딩이 끝나면 이 함수가 실행
    // 로딩이 끝났을 때 처리될 함수를 선언
       reader.onload = () => {
        const feed : FeedState = {
          id : feedList.length > 0? feedList[0].id + 1 : 1,
          story : txtRef.current?.value,
          userImage : profile.userImage,
          username : profile.username,
          dataUrl : reader.result?.toString(),
          creatTime : new Date().getTime(),
        };  

        
        setFeedList([feed, ...feedList]);
    formRef.current?.reset();
  }}};

  const del = (id: number, index: number) => {
    // immer로 state 배열 직접 조작(index로 삭제)
    setFeedList(
        produce((state) => {
          state.splice(index, 1);
        })
      );
    };

  // 컴포넌트가 업데이트되도 유지시킬 수 있는 변수
  // 수정할 feed 객체
  const editItem = useRef<FeedState>
  ({id : 0, story : "", username : profile.username, userImage : profile.userImage, creatTime : 0});

  
  const save = (editItem:FeedState)=>{
      setFeedList(
        produce((state) => {
          const item = state.find((item) => item.id === editItem.id);
          if (item){
            item.story = editItem.story;
            item.dataUrl = editItem.dataUrl;
          }
        })
      );
  // 모달창 닫기
  setIsEdit(false);
  };

  const edit = (item:FeedState) => {
    // setIsEdit로 모달팝업띄우기
    if (feedList.length > 0? feedList[0].id + 1 : 1){
      setIsEdit(true) ;
    // 수정할 feed 객체
    // editItem.current = item;
   } };

    
    return (
    <><h2 className="text-center my-5">Feed</h2>
    {/* isEdit State가 true일 때만 modal 창이 보임 */}
    {isEdit && <FeedEditModal
    editItem={editItem.current}
    onClose={()=>{setIsEdit(false);}}
    onSave ={(editItem)=>{save(editItem)}}/>}
    
      <form className="mt-5" ref={formRef}
        onSubmit={(e) => {
        e.preventDefault();}}>
        <textarea
          className="form-control mb-1 w-100"
          style = {{boxSizing:"border-box"}}
          placeholder="Leave a post here"
          ref={txtRef}>
          </textarea>

        <div className="d-flex">
          <input
            type="file"
            className="form-control me-1"
            accept="image/png, image/jpeg, video/mp4"
            ref={inputRef}/>

          <button
          className="btn btn-primary text-nowrap"
          type="button"
          onClick={()=>{add();}}>입력</button>
          </div>
      </form>

      <div className="mt-3">
        {/* 데이터와 ui요소 바인딩 */}
      {feedList.map((item, index) => (
        <div className="card mt-1"  key={item.id}>
          <div className="card-header d-flex justify-content-start">
          <div style={{ backgroundImage: `url(${item.userImage})`}}
          className={style.thumb}>
      </div>
      <div className="float-sm-end">
            {item.username}</div>
      </div>
          {item.dataUrl && (item.dataUrl.includes("image") ?
          (<img className="card-img-top"
          src = {item.dataUrl}
          alt = "posting">
          </img>) :
              (<video className="card-img-top" controls>
              <source src={item.dataUrl}
              type="video/mp4"></source></video>))}
              
              <div className="card-body">
              <p className="card-text">{item.story}</p>
              <a href="#!"
              className="link-secondary fs-6 float-end"
              onClick={(e)=>{
                e.preventDefault();
                del(item.id, index);}}>삭제</a>
                <a href="#!"
              className="link-secondary fs-6 float-end"
              onClick={(e)=>{
                e.preventDefault();
                edit(item);}}>수정</a></div>
              <div>{getTimeString(item.creatTime)}</div>
              
        </div>)
    )}</div>

    </>
      );
                  };        
export default Feed
