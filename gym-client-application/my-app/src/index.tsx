import * as React from "react";
import { createRoot } from 'react-dom/client';
import { createStore, applyMiddleware, Store } from "redux";
import { Provider } from "react-redux";
import thunk from "redux-thunk";

import App from "./App";
import reducer from "./store/reducer";
import {IArticle,ArticleState,ArticleAction, DispatchType}  from "./store/type"
import { configureStore } from "@reduxjs/toolkit";
const store: Store<ArticleState, ArticleAction> & {
  dispatch: DispatchType;
} = configureStore({reducer : reducer});

const container = document.getElementById('root');
const root = createRoot(container!);
root.render(<App/>)

