import { useEffect, useRef } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useHistory, useParams } from "react-router";
import { Rootstate, AppDispatch } from "../../store";
import { requestModifyContact } from "./contactSaga";

const ContactEdit = () => {
  const {id} = useParams<{id : string}>();
  const contactItem = useSelector((state : Rootstate)=>
  state.contact.data.find((item)=> item.id === +id));


  const isModifyCompleted = useSelector((state:Rootstate)=>state.contact.isModifyCompleted);

  const dispatch = useDispatch<AppDispatch>();
  const history = useHistory();

  const nameEdit = useRef<HTMLInputElement>(null);
  const telEdit = useRef<HTMLInputElement>(null);
  const mailEdit = useRef<HTMLInputElement>(null);
  const memoEdit = useRef<HTMLTextAreaElement>(null);

  useEffect(()=>{
isModifyCompleted && history.push("/contacts")
  },[isModifyCompleted, history])

  const handleSave = () => {
    if (contactItem) {
      const item = {...contactItem};
      item.name = nameEdit.current ? nameEdit.current.value : "";
      item.phone = telEdit.current? telEdit.current.value : "";
      item.email = mailEdit.current? mailEdit.current.value : "";
      item.memo = memoEdit.current? memoEdit.current.value : "";

      // reducer로 state 수정 및 목록으로 이동
      dispatch(requestModifyContact(item)); // saga 대체
      // dispatch(modifyContact(item));
      history.push("/contacts");
    }
  }
  
  return(
    <div style={{width:"40vw"}} className="mx-auto">
    <h2 className= "text-center">Contact Edit</h2>
    <form>
      <table className="table">
        <tbody>
          <tr><th>이름</th><td><input className="form-control" type="text" ref={nameEdit} /></td></tr>
          <tr><th>전화번호</th><td><input className="form-control" type="text" ref={telEdit} /></td></tr>
          <tr><th>이메일</th><td><input className="form-control" type="text" ref={mailEdit} /></td></tr>
          <tr><th>메모</th><td><textarea className="form-control" style={{height:"40vh"}} ref={memoEdit}></textarea></td></tr>
         
        </tbody>
      </table>
    </form>
    <div><button
          className="btn btn-secondary float-start"
          onClick={() => {
            history.push("/contact");
          }}><i className="bi bi-grid-3x3-gap me-1"></i>목록</button>
        <button
          className="btn btn-primary float-end"
          onClick={() => {handleSave();}}><i className="bi bi-check" />저장</button>
      </div>
    </div>
    )
}
export default ContactEdit;