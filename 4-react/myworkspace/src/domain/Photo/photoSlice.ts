import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import {penguin} from "../../common/data"

// 목록 조회 : 4열 그리드 화면으로 목록 조회(프로필, 타이틀, 이미지)
// 사진추가 : 추가버튼으로 제목, 설명, 이미지 파일 선택 후 추가, 목록 버튼
// 데이터 구조를 interface로 만듦
export interface PhotoItem {
  id : number;
  profileUrl : string;
  username : string;
  title : string;
  description? : string; // description : string | undefined와 같음
  photoUrl : string;
  createTime : number | string;
}

interface PhotoState{
  // Map<키, 값>
  // mapid photoItem
  data : PhotoItem[]; // 포토아이템 배열
  isFetched : boolean; // 서버에서 데이터를 받아온지에 대한 정보
}

// photo state를 목록 -> array
const initialState : PhotoState = {
  // id는 숫자이거나, 증가되는 문자열
  data : [{id : 1 , profileUrl : penguin, username :"lhj" , createTime : "", title : "펭귄이", description : "선생님의 펭귄들", photoUrl : penguin}],
  isFetched : false,
}

// photo state를 공유할 것이기 때문에 slice생성하고 store에 넣어야함
const photoSlice = createSlice({
  name : "photo",
  initialState,
  reducers: {
    // PayloadAction<payload타입>
    addPhoto : (state, action : PayloadAction<PhotoItem>) => {
      const photo = action.payload;
      //
      state.data.unshift(photo);
    },
  }
})

export const {addPhoto} = photoSlice.actions;
export default photoSlice.reducer;