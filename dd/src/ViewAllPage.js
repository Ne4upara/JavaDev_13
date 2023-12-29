// ViewAllPage.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { BsEye } from "react-icons/bs";
import dataArr from './test.json'

const ViewAllPage = () => {
    const [data, setData] = useState([]);
    const [error, setError] = useState('');

    useEffect(() => {
        const fetchData = async () => {

            try {
                // Используйте dataArr напрямую для демонстрации целей
                // В реальном приложении вы бы делали здесь запрос к API
                const { urls, error } = dataArr;

                if (error === 'OK') {
                    setData(urls);
                } else {
                    setError('Ошибка при получении данных');
                }
            } catch (error) {
                console.error('Неожиданная ошибка при получении данных', error);
                setError('Неожиданная ошибка при получении данных');
            }
            // try {
            //     const response = await axios.get('http://localhost:80/api/v1/view/all');
            //     const { error, all } = response.data;

            //     if (error === 'OK') {
            //         setData(all);
            //     } else {
            //         setError('Error fetching data');
            //     }
            // } catch (error) {
            //     console.error('Unexpected error while fetching data', error);
            //     setError('Unexpected error while fetching data');
            // }
        };

        fetchData();
    }, []);
    console.log('data', data)
    return (
        <div className='App-container'>
            <h1 className='Auth-title'>View All</h1>
            {error && <p>{error}</p>}


            <div className='Info-title Form-label'>
                <p>ShortUrl</p>
                <p>Content</p>
            </div>
            {data.map((item, index) => (
                <div key={index} className='Info-all'>
                    <div className='info-text'>
                    <p>{item.shortUrl}</p>
                    <p><BsEye /> {item.count}</p>
                    </div>
                    <div className='info-text'>
                    <p>{item.content}</p>
                    </div>
                </div>
            ))}
        </div>
    );
};

export default ViewAllPage;
