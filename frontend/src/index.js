import React from "react";
import ReactDOM from "react-dom";
import { Provider } from "react-redux";
import { BrowserRouter as Router, Route } from "react-router-dom";
import Login from "./Login";
import { store } from "./store";
import App from "./App";
import * as serviceWorker from "./serviceWorker";
import "./index.css";
import RoleSelect from "./RoleSelect";
import Admin from "./Admin";

ReactDOM.render(
  <Provider store={store}>
    <Router>
      <div className="App">
        <Route component={App} exact path="/" />
        <Route component={Login} path="/login" />
        <Route component={RoleSelect} path="/role_select" />
        <Route component={Admin} path="/admin" />
      </div>
    </Router>
  </Provider>,
  document.getElementById("root")
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
