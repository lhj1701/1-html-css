import "./App.scss";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import { Suspense, lazy } from "react";
import { Provider } from "react-redux"; // react 앱에 redux store를 제공
import { store } from "./store"; // redux store
import FullCalendar from "@fullcalendar/react";
import Home from "./features/home/Home";
import Profile from "./features/profile/Profile";
import Progress from "./components/progress/progress";
import AlertStack from "./components/alert/AlertStack";
import EventMessage from "./components/EventMessage";
//react == 컴포넌트 개발 라이브러리
const Feed = lazy(()=> import ("./features/feed/Feed_이효정"));
const Todo = lazy(()=> import ('./features/todo/Todo'));
const TodoInlineEdit = lazy(()=> import ('./features/todo/TodoInlineEdit'));
const Contact = lazy(()=> import ('./features/contact/Contact_이효정'));
const ContactInline = lazy(()=> import ('./features/contact/ContactInlineEdit'));
const ContactCreate = lazy(()=> import ('./features/contact/ContactCreate'));
const ContactDetail = lazy(()=> import("./features/contact/ContactDetail"));
const ContactEdit = lazy(()=> import("./features/contact/ContactEdit"));
const Photo =lazy(() => import("./features/photo/Photo"));
const PhotoCreate = lazy(()=> import("./features/photo/PhotoCreate"));
const PhotoDetail = lazy(()=> import("./features/photo/PhotoDetail"));
const PhotoEdit = lazy(()=> import("./features/photo/PhotoEdit"));
const Calendar = lazy(()=> import("./features/calendar/fullcalendar"));

function App() {
  return (
    <Provider store={store}>
    <Router>
      {/* maincontainer */}
      <div className="mx-auto">
        <header className="app-bar d-flex justify-content-end bg-primary shadow">
          <Profile/></header>
        <nav
          className="drawer-menu position-fixed bg-light shadow-sm"
        ><h3 className= "ms-2">my workspace</h3>
          <ul>
          <li>👇Feed 클릭하면 포스팅이 가능해요👇</li>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/feed">Feed</Link></li>
          <li><Link to="/Todo">Todo</Link></li>
          <li><Link to="/TodoInlineEdit">TodoInlineEdit</Link></li>
          <li><Link to="/contacts">Contact</Link></li>
          <li><Link to="/contactInline">Contact-inline</Link></li>
          <li><Link to="/photos">Photos</Link></li>
          <li><Link to="/calendar">Calendar</Link></li>
          </ul>
        </nav>
        <main className="content-container">
          <Suspense fallback={<div>Loading...</div>}>
            <Switch>
              {/* 스위치 영역에 컴포넌트가 로딩됨 */}
              {/* exact : 속성은 true/false, 경로가 정확히 일치할때만 */}
              <Route path="/" component={Home} exact/>
              <Route path="/feed" component={Feed} />
              <Route path="/Todo" component={Todo} />
              <Route path="/TodoInlineEdit" component={TodoInlineEdit} />
              <Route path="/contacts" component={Contact} exact/>
              <Route path="/contacts/create" component={ContactCreate}/>
              <Route path="/contacts/detail/:id" component={ContactDetail} />
              <Route path="/contacts/edit/:id" component={ContactEdit} />
              <Route path="/contactInline" component={ContactInline} />
             <Route path="/photos" component={Photo} exact/> 
              <Route path="/photos/create" component={PhotoCreate}/>
              {/* id라는 매개변수를 url 경로에 넘김, path parameter */}
              <Route path="/photos/detail/:id" component={PhotoDetail} />
              <Route path="/photos/edit/:id" component={PhotoEdit} />
              <Route path="/calendar" component={Calendar} />
            </Switch>
          </Suspense>
          <Progress/>
          <AlertStack/>
          <EventMessage/>
        </main>
      </div>
    </Router>
    </Provider>
  );
}
 // App.tsx 모듈의 기본 내보내기를 App 함수로 함
export default App;