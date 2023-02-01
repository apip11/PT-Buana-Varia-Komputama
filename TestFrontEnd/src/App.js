import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import { Login } from './components/Login';
import { Register } from './components/Register';
import { Dashboard } from './components/dashboard/Dashboard';

function App() {
  return (

    <BrowserRouter>

      <Routes>

        <Route path='/login' element={<Login />} />
        <Route path='/register' element={<Register />} />
        <Route path='/' element={<Dashboard />} />

      </Routes>

    </BrowserRouter>

    // <Login />
  );
}

export default App;
