//导入react组件
import React, { Fragment, useEffect } from "react";
//导入路由组件
import { BrowserRouter, Route } from "react-router-dom";
//导入自定义HTML组件
//导航栏
import NavBar from "./components/layout/NavBar";
import store from "./store";

//Redux组件
import { Provider } from "react-redux";

//样式
import "./App.css";

function App() {
  return (
    /* 加载store，加载redux */
    <Provider store={store}>
      {/* 路由 */}
      <BrowserRouter>
        <Fragment>
          {/* 导航栏 */}
          <NavBar />
        </Fragment>
      </BrowserRouter>
    </Provider>
  );
}

export default App;
