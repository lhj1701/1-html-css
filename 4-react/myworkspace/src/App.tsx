import "./App.scss";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import { Suspense, lazy } from "react";
import Profile from "./domain/profile/Profile";
import { Provider } from "react-redux"; // react 앱에 redux store를 제공
import { store } from "./store"; // redux store
import PhotoDetail from "./domain/Photo/PhotoDetail";

//react == 컴포넌트 개발 라이브러리
const Feed = lazy(()=> import ("./domain/feed/Feed_이효정"))
const Todo = lazy(()=> import ('./domain/todo/Todo'))
const Contact = lazy(()=> import ('./domain/contact_이효정'))
const Photo =lazy(() => import("./domain/Photo/Photo"))
const PhotoCreate = lazy(()=> import("./domain/Photo/PhotoCreate"))
function App() {
  return (
    <Provider store={store}>
    <Router>
      {/* maincontainer */}
      <div style={{ width: "700px" }} className="mx-auto">
        <header className="app-bar d-flex justify-content-end bg-primary shadow">
          <Profile/></header>
        <nav
          className="drawer-menu position-fixed bg-light shadow-sm"
        ><h3 className= "ms-2">my workspace</h3>
          <ul>
          <li>👇아래 Feed 클릭하면 포스팅이 가능해요👇</li>
          <li><Link to="/feed">Feed</Link></li>
          <li><Link to="/Todo">Todo</Link></li>
          <li><Link to="/Contact">Contact</Link></li>
          <li><Link to="/Photo">Photos</Link></li>
          </ul>
        </nav>
        <main className="content-container">
          <Suspense fallback={<div>Loading...</div>}>
            <Switch>
              {/* 스위치 영역에 컴포넌트가 로딩됨 */}
              {/* exact : 속성은 true/false, 경로가 정확히 일치할때만 */}
              <Route path="/feed" component={Feed} />
              <Route path="/Todo" component={Todo} />
              <Route path="/Contact" component={Contact} />
              <Route path="/photos" component={Photo} exact/>
              <Route path="/photos/create" component={PhotoCreate}/>
              <Route path="/photos/:id" component={PhotoDetail} />
            </Switch>
          </Suspense>
        </main>
      </div>
    </Router>
    </Provider>
  );
}

export default App;