import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './Home';
import AuthPage from './AuthPage';
import RegistrationPage from './RegistrationPage';
import ViewAllPage from './ViewAllPage';
import './App.css'
import './styles/divWithImage.css'

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path='/' index element={<Home />} />
                <Route path="/login" element={<AuthPage />} />
                <Route path="/register" element={<RegistrationPage />} />
                <Route path="/viewAll" element={<ViewAllPage />} />
            </Routes>

        </Router>
    );
};

export default App;
