import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import AuthPage from './AuthPage';
import RegistrationPage from './RegistrationPage';
import ViemAllPage from "./ViemAllPage";

const App = () => {
    return (
        <Router>
            <div>
                <h1>Team Final Project </h1>
                <div className="divWithImage">
                    <img src="/images/page1.jpg" alt="Start page"/>
                </div>
                <div className="divWithImage">
                    <img src="/images/page2.jpg" alt="Foto team"/>
                </div>
                <nav>
                    <ul>
                        <li>
                            <button>
                                <Link to="/login">Login</Link>
                            </button>
                        </li>
                        <li>
                            <button>
                                <Link to="/register">Register</Link>
                            </button>
                        </li>
                        <li>
                            <button>
                                <Link to="/viemAll">Viem All</Link>
                            </button>
                        </li>
                    </ul>
                </nav>

                <Routes>
                    <Route path="/login" element={<AuthPage/>}/>
                    <Route path="/register" element={<RegistrationPage/>}/>
                    <Route path="/viemAll" element={<ViemAllPage/>}/>
                </Routes>

            </div>
        </Router>
    );
};

export default App;
