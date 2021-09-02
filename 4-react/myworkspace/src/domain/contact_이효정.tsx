import { useRef, useState } from "react";
import produce from "immer";

interface ContactState {
  id : number;
  name : string | undefined;
  tel : string | undefined;
  mail : string | undefined;
  delBtn? : string;
  }

const Contact = () => {
  const [contactList, setContactList] = useState<ContactState[]>([
    // { id: 1, name: "이효정", tel : "010-8485-5998", mail : "gywjd1701@gmail.com"}
  ]);

  const nameRef = useRef<HTMLInputElement>(null);
  const telRef = useRef<HTMLInputElement>(null);
  const mailRef = useRef<HTMLInputElement>(null);
  const formRef = useRef<HTMLFormElement>(null);
  // const tblRef = useRef<HTMLTableRowElement>(null);

  const add = () => {
    const contact: ContactState = {
      id: contactList.length > 0 ? contactList[0].id + 1 : 1,
      name: nameRef.current?.value,
      tel : telRef.current?.value,
      mail : mailRef.current?.value,
    };

    setContactList(
      produce((state) => {
        state.unshift(contact);
      })
    );

    formRef.current?.reset();
  };

  const del = (id: number, index: number) => {
    setContactList(
      produce((state) => {
        state.splice(index, 1);
      })
    );
  };

  return (
    <>
      <h2 className="text-center my-5">연락처관리</h2>
      <form
        className="d-flex"
        ref={formRef}
        onSubmit={(e) => e.preventDefault()}
      >
        <input
          type="text"
          className="form-control me-2"
          placeholder="이름"
          ref={nameRef}
        />
        <input
          type="text"
          className="form-control me-2"
          placeholder="전화번호"
          ref={telRef}
        />
        <input
          type="text"
          className="form-control me-2"
          placeholder="이메일"
          ref={mailRef}
        />
        <button
          type="button"
          className="btn btn-primary text-nowrap"
          onClick={() => {add();}}>추가
        </button>
      </form>
      <table className="table table-striped text-center mx-auto"
      style={{borderCollapse:"collapse"}}>
        <thead>
          <tr>
            <th>이름</th>
            <th>전화번호</th>
            <th>이메일</th>
            <th>작업</th>
            </tr>
            </thead>
        <tbody> 
        {contactList.map((item, index) => (
            <tr key={item.id} >
              <td >{item.name}</td>
              <td>{item.tel}</td>
              <td>{item.mail}</td>
              <button
              className="btn btn-outline-secondary btn-sm text-nowrap"
              onClick={() => {del(item.id, index);}}>삭제</button>
              </tr>
          ))}
        </tbody>
        </table>
    </> 
  );
  }

export default Contact;