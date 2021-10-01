import { useRef, useState } from "react";
import produce from "immer";

import TodoEditModal from "./TodoEditModal";
// ./type.ts/js/tsx가 없으면, ./type/index.ts/js/tsx 로딩
import { TodoItemState } from "./type";
import { useSelector } from "react-redux";
import { Rootstate } from "../../store";


const getTimeString = (unixtime: number) => {

  const now = new Date() ; // 현재 날짜-시간객체
  // 1초 : 1000
  // 1분 : 60*1000
  // 1시간 : 60*60*1000
  // 1일 : 24*60*60*1000
  const day =24*60*60*1000
  now.getTime();// 현재 시간의 밀리세컨드
  const dateTime = new Date(unixtime);
  // 현재시간보다 24 시간 이내면 시간을 보여주고
  // 현재시간보다 24시간 초과면 날짜를 보여줌
  return unixtime - now.getTime() >= day
  ?  dateTime.toLocaleDateString
  : dateTime.toLocaleTimeString
  // `${dateTime.toLocaleDateString()} ${dateTime.toLocaleTimeString()}`;
};

const Todo = () => {

  // profile state를 가져옴 + state 가 변경되면 컴포넌트를 업데이트(diff + rendering 함)
  const profile = useSelector((state:Rootstate)=>state.profile)
  const [todoList, setTodoList] = useState<TodoItemState[]>([
    { id: 2, memo: "Typescript", username : profile.username, createTime: new Date().getTime() },
    { id: 1, memo: "React State 연습", username : profile.username, createTime: new Date().getTime() },
  ]);

  // 수정팝업을 띄울지 아닐지
  const [isEdit, setIsEdit] = useState(false);

  const inputRef = useRef<HTMLInputElement>(null);
  const formRef = useRef<HTMLFormElement>(null);
  const ulRef = useRef<HTMLUListElement>(null);

  const add = () => {
    const todo: TodoItemState = {
      id: todoList.length > 0 ? todoList[0].id + 1 : 1,
      memo: inputRef.current?.value,
      username : profile.username,
      createTime: new Date().getTime(),
    };

    // immer 없이 새로운 배열을 생성하여 state 변경
    // setTodoList([todo,...todoList]);

    // current state -> draft state->next state
    // draft state를 조작함
    setTodoList(
      // produce(([draftstate 변수]) => {draft state변수 조삭})
      // 반환 객체는 변경된 state(next state)
      produce((state) => {
        //draft state 배열에 추가
        //draft state 타입은 TodoState[]
        state.unshift(todo);
      })
    );

    formRef.current?.reset();
  };

  // const del = (id: number ) => {
  // 불변성 때문에 splice 함수를 사용할 수 없음
  // 주로 filter 함수를 사용
  // filter 함수로 해당 id를 제외하고 새로운 배열로 리턴
  // immer 없이 사용
  // setTodoList(totoList.filter((item)=>item.id!==id));

  const del = (id: number, index: number) => {
    // immer로 state 배열 직접 조작(index로 삭제)
    setTodoList(
      produce((state) => {
        state.splice(index, 1);
      })
    );
  };

  // 컴포넌트가 업데이트 되도 유지시킬 수 있는 변수
  // 수정할 todo 객체
  const editItem = useRef<TodoItemState>({id:0, memo:"", username:profile.username, createTime:0});

  const edit = (item : TodoItemState) => {
    // 모달팝업 보여주기/ 없애기
    setIsEdit(true);
    editItem.current = item;
    // 수정할 todo객체
  };

  const save = (editItem:TodoItemState)=>{
    setTodoList(
      produce((state) => {
        const item = state.find((item) => item.id === editItem.id);
        if (item) {
          item.memo = editItem.memo;
        }
      })
    );
    // 모달 창 닫기
    setIsEdit(false);
      };
    

  return (
    <div style={{width:"40vw"}}>
      <h2 className="text-center my-5">할 일 관리</h2>
      <div>
      <img src={profile.userImage} width={150} height={100}
      alt={profile.username}/>
      {/* 프로필정보 확인용 */}
      <span>{profile.username}</span>
      </div>
      {/* isEdit state 가 true일때만 modal 창이 보임 */}
      {isEdit&&(<TodoEditModal
      item={editItem.current}
      onClose={()=>{setIsEdit(false);}}
      onSave={(editItem)=>{save(editItem)}}/>)}
      <form
        className="d-flex"
        ref={formRef}
        onSubmit={(e) => e.preventDefault()}
      >
        <input
          type="text"
          className="form-control me-2"
          placeholder="할 일 ..."
          ref={inputRef}
        />
        <button
          type="button"
          className="btn btn-primary text-nowrap"
          onClick={() => {add();}}>추가
        </button>
      </form>
      <ul id="ul-list" className="list-group list-group-flush mt-3" ref={ulRef}>
        {/* 데이터와 UI요소 바인딩 */}
        {todoList.map((item, index) => (
          <li className="list-group-item d-flex" key={item.id}>
            <div className="w-100">
              <span className="me-1">{item.memo}</span>
              <span style={{ fontSize: "0.75rem" }}>
                - {item.username} {getTimeString(item.createTime)}
              </span>
            </div>
            <button
              className="btn btn-outline-secondary btn-sm text-nowrap"
              onClick={() => {
                edit(item);
              }}
            >
              수정
            </button>
            <button
              className="btn btn-outline-secondary btn-sm text-nowrap"
              onClick={() => {
                del(item.id, index);
              }}
            >
              삭제
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Todo;