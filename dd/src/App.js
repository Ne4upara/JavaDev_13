import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './Home';
import AuthPage from './AuthPage';
import RegistrationPage from './RegistrationPage';
import ViewAllPage from './ViewAllPage';
import './App.css'
import './styles/divWithImage.css'
import About from './About';

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path='/' element={<Home />}>
                    <Route path="about" element={<About />} />
                    <Route path="login" element={<AuthPage />} />
                    <Route path="register" element={<RegistrationPage />} />
                    <Route path="viewAll" element={<ViewAllPage />} />
                </Route>
            </Routes>

        </Router>
    );
};

export default App;
