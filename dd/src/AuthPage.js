import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const AuthPage = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');

    const handleLogin = async () => {
        try {
            const response = await axios.post('http://localhost:80/api/v1/auth/login', {
                username,
                password,
            });

            const { error, authToken } = response.data;

            if (error === 'OK') {
                // Вход выполнен успешно
                console.log('Успешный вход', authToken);
            } else if (error === 'INVALID_USER_NAME') {
                setError('Имя пользователя пустое');
            } else if (error === 'INVALID_PASSWORD') {
                setError('Пароль должен быть не менее 8 символов');
            }
        } catch (error) {
            console.error('Произошла неожиданная ошибка при регистрации', error.response?.data || error.message);
            setError('Произошла неожиданная ошибка при регистрации');
        }
    };

    return (
        <div>
            <h1>Login Page</h1>
            <form>
                <label>
                    Username:
                    <input
                        type="text"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                </label>
                <br/>
                <label>
                    Password:
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </label>
                <br/>
                <button type="button" onClick={handleLogin}>
                    Login
                </button>
            </form>
            {error && <p>{error}</p>}
            <p>
                Нет аккаунта? <Link to="/register">Зарегистрируйтесь</Link>.
            </p>
        </div>
    );
};

export default AuthPage;
