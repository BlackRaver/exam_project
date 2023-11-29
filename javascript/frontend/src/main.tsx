import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import { Provider } from 'react-redux'
import { ApiProvider } from '@reduxjs/toolkit/dist/query/react/' 
import { apiRelict } from './components/api/apiRelict.ts'
import { store } from './store/store.ts'

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <Provider store={store}>
    <ApiProvider api={apiRelict}>

       <App />
    </ApiProvider>
   </Provider>
  </React.StrictMode>
)
