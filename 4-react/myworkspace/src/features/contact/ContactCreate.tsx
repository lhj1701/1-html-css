import { useEffect, useRef } from "react"
import { useDispatch, useSelector } from "react-redux";
import { useHistory } from "react-router-dom";
import { AppDispatch, Rootstate } from "../../store";
import { ContactItem } from "./contactSlice";
import {requestAddContact} from "./contactSaga"

const ContactCreate = () =>{
  const name = useRef<HTMLInputElement>(null);
  const phone = useRef<HTMLInputElement>(null);
  const email = useRef<HTMLInputElement>(null);
  const memo = useRef<HTMLTextAreaElement>(null);

  //컨택트 데이터 가져오기
  const contactData =useSelector((state:Rootstate)=>state.contact.data);
  // 추가완료 여부
  // 1.state 변경감지 및 값 가져오기
  const isAddCompleted = useSelector((state:Rootstate)=>state.contact.isAddCompleted);

  const dispatch = useDispatch<AppDispatch>();

  const history = useHistory();

   //2. isAddCompleted 값이 변경되면 처리 (state값이 변경되면 처리되는 함수)
  useEffect(()=>{
  isAddCompleted && history.push("/contacts");
  // //isAddCompleted를 초기화
  // dispatch(initialCompleted())
  },[isAddCompleted, history, dispatch])

  const add = () => {
    const contact: ContactItem = {
      id: contactData.length ? contactData[0].id + 1 : 1,
      name : name.current ? name.current.value : "",
      phone : phone.current? phone.current.value : "",
      email : email.current? email.current.value : "",
      memo : memo.current? memo.current.value : "",
      createdTime : new Date().getTime(),
    };
    //dispatch(addContact(contact)); // 기존 redux액션
    dispatch(requestAddContact(contact)); //saga action으로 대체
  //   history.push("/contact");
  }
  return (
    <div style={{width:"40vw"}} className="mx-auto">
    <h2 className= "text-center">Contact Create</h2>
    <form>
      <table className="table">
        <tbody>
          <tr><th>이름</th><td><input className="form-control" type="text" ref={name} /></td></tr>
          <tr><th>전화번호</th><td><input className="form-control" type="text" ref={phone} /></td></tr>
          <tr><th>이메일</th><td><input className="form-control" type="text" ref={email} /></td></tr>
          <tr><th>메모</th><td><textarea className="form-control" style={{height:"40vh"}} ref={memo}></textarea></td></tr>
        </tbody>
      </table>
    </form>
    <div><button
          className="btn btn-secondary float-start"
          onClick={() => {
            history.push("/contacts");
          }}><i className="bi bi-grid-3x3-gap me-1"></i>목록</button>
        <button
          className="btn btn-primary float-end"
          onClick={() => {add();}}><i className="bi bi-check" />저장</button>
      </div>
    </div>
    )
}
export default ContactCreate;