import axios from "axios";

export interface ContactPagingResponse{
  content : ContactItemResponse[],
  totalPages: number,
  totalElements: number,
  last: boolean,
  size: number,
  number: number,
}

// 서버로부터 받아오는 데이터 1건에 대한 타입
export interface ContactItemResponse{
  id:number,
  name : string | undefined;
  phone : string | undefined;
  email : string| undefined;
  memo : string | undefined;
  createdTime: number;
}

export interface ContactItemRequest{
  name : string | undefined;
  phone : string | undefined;
  email : string | undefined;
  memo : string | undefined;
}

// 서버하고 데이터 연동하는 api처리 목록을 별도의 객체로 작성
//process.env.변수명
const contactApi = {

  //axios.get<응답데이터의 타입>(응답url)
  //GET 응답url HTTP/1.1
  fetch:()=>
  axios.get<ContactItemResponse[]>(`${process.env.REACT_APP_API_BASE}/contacts`),
  
  fetchPaging: (page:number,size:number) =>
    axios.get<ContactPagingResponse>(`${process.env.REACT_APP_API_BASE}/contacts/paging?page=${page}&size=${size}`),
  //axios.post<응답타입>(요청URL,요청객체(JSON바디))
  //POST 요청 URL HTTP/1.1
  add:(contactItem:ContactItemRequest)=>
  axios.post<ContactItemResponse>(`${process.env.REACT_APP_API_BASE}/contacts`,contactItem),

  //axios.delete<응답타입>(요청URL);
  //DELETE 요청URL HTTP/1.1
  remove:(id : number) =>
  axios.delete<boolean>(`${process.env.REACT_APP_API_BASE}/contacts/${id}`),
  
  //axios.PUT<응답타입>(요청URL);
  //PUT 요청URL HTTP/1.1
  modify:(id : number, contactItem : ContactItemRequest) =>
  axios.put<ContactItemResponse>(`${process.env.REACT_APP_API_BASE}/contacts/${id}`,contactItem),
}
export default contactApi;