// ViewAllPage.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { BsEye } from "react-icons/bs";
import dataArr from './test.json'

const ViewAllPage = () => {
    const [data, setData] = useState([]);
    const [error, setError] = useState('');
    const [selectedOption, setSelectedOption] = useState(null);


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

    const handleConvert = async () => { 
        // тут должна быть логика обработки конвертации ссылок 
    }

    const handleRadioChange = (value) => {
        setSelectedOption(value);
        // сюда при смене радио кнопки надо повесить обработку фильтра с бека 
        // запросом или как то еще
    };

    console.log('data', data)
    const isAuthToken = localStorage.getItem('authToken')
    return (
        <div className='App-container'>
            <h1 className='Auth-title'>View All</h1>
            {error && <p>{error}</p>}
            {isAuthToken ?
                <>
                    <div className='Convert-block'>
                        <form className='Form'>
                            <label className='Form-label'>
                                <p>
                                    Original Url:
                                </p>
                                <input
                                    type="text"
                                    value={''}
                                />
                            </label>
                            <br />
                            <label className='Form-label'>
                                <p>
                                    Description:
                                </p>
                                <input
                                    type="password"
                                    value={''}
                                />
                            </label>
                            <br />
                        </form>
                        <button type="button" onClick={handleConvert} className='button'>
                            Convert
                        </button>
                    </div>
                    <div className='radio-block'>
                        <label className="radio-label">
                            <input
                                type="radio"
                                name="radioGroup"
                                value="option1"
                                checked={selectedOption === 'option1'}
                                onChange={() => handleRadioChange('option1')}
                            />
                            user urls
                        </label>
                        <label className="radio-label">
                            <input
                                type="radio"
                                name="radioGroup"
                                value="option2"
                                checked={selectedOption === 'option2'}
                                onChange={() => handleRadioChange('option2')}
                            />
                            active urls
                        </label>
                    </div>
                    <>
                    <div className='Info-title Form-label'>
                        <p>ShortUrl</p>
                        <p>OriginalUrl</p>
                    </div>
                    {data.map((item) => (
                        <div key={item.id} className='Info-all'>
                            <div className='info-text'>
                                <p><a href={item.shortUrl}>{item.shortUrl}</a></p>
                                <p><BsEye /> {item.visitCount}</p>
                            </div>
                            <div className='info-text'>
                                <span><a href={item.originalUrl}>{item.originalUrl}</a></span>
                            </div>
                            <button type='button' className='button'>edit</button>
                            {/* сюда кнопкам надо певесить обработчик по onClick */}
                            <button type='button' className='button'>delete</button>
                        </div>
                    ))}
                </>
                </>
                :
                <>
                    <div className='Info-title Form-label'>
                        <p>ShortUrl</p>
                        <p>OriginalUrl</p>
                    </div>
                    {data.map((item) => (
                        <div key={item.id} className='Info-all'>
                            <div className='info-text'>
                                <p><a href={item.shortUrl}>{item.shortUrl}</a></p>
                                <p><BsEye /> {item.visitCount}</p>
                            </div>
                            <div className='info-text'>
                                <span><a href={item.originalUrl}>{item.originalUrl}</a></span>
                            </div>
                        </div>
                    ))}
                </>
            }
        </div>
    );
};

export default ViewAllPage;
