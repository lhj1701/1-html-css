import "./App.scss";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import { Suspense, lazy } from "react";

const Feed = lazy(()=> import ('./features/feed/Feed_이효정'))
const Modal = lazy(()=> import ('./features/todo/Todo'))
function App() {
  return (
    <Router>
    <div style={{ width: "700px" }} className="mx-auto">
        <header style={{height:"50px"}} className="bg-primary">App Bar</header>
        <nav
          style={{ width: "200px", height: "100vh", top: "20px" }}
          className="position-fixed"
        >
          <ul>
          <li>👇아래 Feed 클릭하면 포스팅이 가능해요👇</li>
          <li><Link to="/feed">Feed</Link></li>
          <li><Link to="/modal">Modal</Link></li>
          </ul>
        </nav>
        <main style={{ marginLeft: "200px", marginTop: "20px" }}>
          <Suspense fallback={<div>Loading...</div>}>
            <Switch>
              <Route path="/feed" component={Feed} />
              <Route path="/modal" component={Modal} />
            </Switch>
          </Suspense>
        </main>
      </div>
    </Router>
  );
}

export default App;