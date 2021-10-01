import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useHistory, useParams } from "react-router";
import { Rootstate, AppDispatch } from "../../store";
import { requestRemoveContact } from "./contactSaga";

const getTimeString = (unixtime: number) => {
  const dateTime = new Date(unixtime);
  return `${dateTime.toLocaleDateString()} ${dateTime.toLocaleTimeString()}`;
};

const ContactDetail = () => {

  const {id} = useParams<{id : string}>();
  const contactItem = useSelector((state:Rootstate)=>
  state.contact.data.find((item)=>item.id=== +id));

  // 삭제 여부 감지 및 가져오기
  const isRemoveCompleted = useSelector(
    (state:Rootstate) => state.contact.isRemoveCompleted);

  const dispatch = useDispatch<AppDispatch>();
  const history = useHistory();

  useEffect(()=>{
    isRemoveCompleted && history.push("/contacts");
  },[isRemoveCompleted,history]);

  const handleDel = () => {
    dispatch(requestRemoveContact(+id)); // saga 액션으로 대체
    // dispatch(removeContact(+id)); // id 값만 넣어서 삭제
    // history.push("/contacts") // 목록화면으로 이동

   }
  return (
    <div style={{width:"40vw"}} className="mx-auto">
        <h2 className= "text-center">Contact detail</h2>
        {!contactItem && <div className="text-center my-5">데이터가 없습니다.</div>}
          {contactItem && (<table className="table">
            <tbody>
              <tr><th>이름</th><td>{contactItem.name}</td></tr>
              <tr><th>전화번호</th><td>{contactItem.phone}</td></tr>
              <tr><th>이메일</th><td>{contactItem.email}</td></tr>
              <tr><th>메모</th><td>{contactItem.memo}</td></tr>
              <tr><th>작성일시</th><td>{getTimeString(contactItem.createdTime)}</td></tr>
            </tbody>
          </table>)} 
          <div className="d-flex">
            <div style={{ width: "50%" }}>
              <button
                className="btn btn-secondary me-1"
                onClick={() => {
                  history.push("/contacts");
                }}
              >
                <i className="bi bi-grid-3x3-gap me-1"></i>
                목록
              </button>
            </div>
            <div style={{ width: "50%" }} className="d-flex justify-content-end">
              <button
                className="btn btn-primary me-1"
                onClick={() => {
                  history.push(`/contacts/edit/${id}`);
                }}
              >
                <i className="bi bi-pencil me-1" />
                수정
              </button>
              <button
                className="btn btn-danger"
                onClick={() => {
                  handleDel();
                }}
              >
                <i className="bi bi-trash me-1" />
                삭제
              </button>
            </div>
          </div>
        </div>
      );
    };
    

export default ContactDetail;