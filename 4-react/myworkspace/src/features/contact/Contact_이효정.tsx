import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useHistory } from "react-router-dom";
import { AppDispatch, Rootstate } from "../../store";
import { requestFetchContacts, requestFetchPagingContacts } from "./contactSaga";
import Pagination from "../../components/pagination";

const getTimeString = (unixtime: number) => {
  const dateTime = new Date(unixtime);
  return `${dateTime.toLocaleDateString()} ${dateTime.toLocaleTimeString()}`;
};

const Contact = () => {

  const contact = useSelector((state:Rootstate)=>state.contact);
  const history = useHistory(); // 컴포넌트 이동을 코드로 제어할 수 있음
  const dispatch = useDispatch<AppDispatch>();

  const [currentPage,setCurrentPage] = useState<number>(0);

  // 컴포넌트가 마운팅되는 시점에 실행
  // dispatch객체가 생성되고 constact.isFetched를 가져올 때와 바뀔때마다 실행됨
  // dispatch 객체는 위에서 생성된 후 바뀌지 않으므로 dispatch객체에 따른 effect가 발생하지는 않음
  useEffect(()=>{
    // console.log(dispatch);
    // 데이터 fetch가 안되었으면 데이터를 받아옴
if(!contact.isFetched){
  //서버에서 데이터를 받아오는 action을 디스패치함
  // dispatch(requestFetchContacts());
dispatch(requestFetchPagingContacts({page:0, size:contact.pageSize}));
}
  },[dispatch, contact.isFetched]);

  const handlePageChanged = (page:number)=>{
    console.log(page);
    // setCurrentPage(page);
    dispatch(requestFetchPagingContacts({page:0, size:contact.pageSize? contact.pageSize : 2}));
  }

  const handlePageSizeChanged = (e: React.ChangeEvent<HTMLSelectElement>) => {
    console.log(e.currentTarget.value);
    dispatch(
      requestFetchPagingContacts({
        page: contact.page,
        size: +e.currentTarget.value,
      })
    );
  };

  return (
    <>
      <h2 className="text-center my-5">연락처관리</h2>
      <div className="d-flex justify-content-end mb-2">
      <select
          className="form-select form-select-sm me-2"
          style={{ width: "60px" }}
          onChange={(e) => {
            handlePageSizeChanged(e);
          }}
        >
          {[2, 3, 6].map((size) => (
            <option value={size} selected={contact.pageSize === size}>
              {size}
            </option>
          ))}
        </select>
        <button
          type="button"
          className="btn btn-secondary text-nowrap float-end"
          onClick={() => {dispatch(requestFetchContacts())}}>
          <i className="bi bi-arrow-clockwise me-1"/>새로고침</button>
          <button
          type="button"
          className="btn btn-primary text-nowrap float-end"
          onClick={() => {history.push("/contacts/create");}}>
          <i className="bi bi-plus me-1"/>추가</button></div>
      <table className="table table-striped text-center mx-auto"
      style={{borderCollapse:"collapse"}}>
        <thead>
          <tr>
            <th>번호</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>이메일</th>
            <th>작성일시</th>
            </tr>
            </thead>
        <tbody> 
        {contact.data.map((item, index) => (
            <tr key={item.id} onClick={()=>{ history.push(`/contacts/detail/${item.id}`)}} style={{cursor: "pointer"}}>
              <td>{item.id}</td>
              <td>{item.name}</td>
              <td>{item.phone}</td>
              <td>{item.email}</td>
              <td><span>{getTimeString(item.createdTime)}</span></td>
              </tr>
          ))}
        </tbody>
        </table>
        <div>
    <Pagination blockSize={2} // 고정값
    totalPages={contact.totalPages}
    currentPage={contact.page}
    onPageChanged={handlePageChanged}/>
    </div>
    </> 
  );
  }

export default Contact;