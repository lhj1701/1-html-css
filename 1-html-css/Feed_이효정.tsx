import { useRef, useState } from "react";
import produce from "immer";

interface FeedState {
id : number,
story? : string | undefined,
dataUrl? : string | undefined,
creatTime : number,
}

const getTimeString = (unixtime: number) => {
  const dateTime = new Date(unixtime);
  return `${dateTime.toLocaleDateString()} ${dateTime.toLocaleTimeString()}`;
};

const Feed = () => {
  const [feedList,setFeedList] = useState<FeedState[]>([
  ]);
  const txtRef = useRef<HTMLTextAreaElement>(null);
  const inputRef = useRef<HTMLInputElement>(null);
  const formRef = useRef<HTMLFormElement>(null);

  const add = () => {
     // files가 있어도 선택을 안하면 length 0
     if (inputRef.current?.files?.length){
    const file = inputRef.current?.files[0];
    const reader = new FileReader();
      reader.readAsDataURL(file);
       reader.onload = () => {
        const feed : FeedState = {
          id : feedList.length > 0? feedList[0].id + 1 : 1,
          story : txtRef.current?.value,
          dataUrl : reader.result?.toString(),
          creatTime : new Date().getTime(),
        };  
    setFeedList(
      produce((state) => {
        state.unshift(feed);
      })
    );
    formRef.current?.reset();
  }}};

  const del = (id: number, index: number) => {
    setFeedList(
        produce((state) => {
          state.splice(index, 1);
        })
      );
    };
    return (
    <><h2 className="text-center my-5">Feed</h2>
      <form
        className="mt-5"
        ref={formRef}
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

      <div id="div-list" className="mt-3">
      {feedList.map((item, index) => (
        <div className="card mt-1"  key={item.id}>
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
              <a href="#"
              className="link-secondary fs-6 float-end"
              onClick={()=>{
                del(item.id, index);}}>삭제</a>
              <div>{getTimeString(item.creatTime)}</div>
            </div>
          </div>
      ))}
          </div>
    </>
  );
              }
export default Feed;
