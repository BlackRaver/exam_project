import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import { Provider } from 'react-redux'
import { ApiProvider } from '@reduxjs/toolkit/dist/query/react/' 
import { apiRelict } from './components/api/apiRelict.ts'
import { store } from './store/store.ts'
import { createBrowserRouter, RouterProvider, Route } from 'react-router-dom'
import RelictDetailsPage from './components/RelictDetailsPage.tsx'

const router = createBrowserRouter([
{
  path: "/",
  element: <App/>
},
{
path: "/relict/:id",
element: <RelictDetailsPage/>
}
]);

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <Provider store={store}>
    <ApiProvider api={apiRelict}>
       <RouterProvider router={router}/>
    </ApiProvider>
   </Provider>
  </React.StrictMode>
)
