// ViewAllPage.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

const ViewAllPage = () => {
    const [data, setData] = useState([]);
    const [error, setError] = useState('');

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('http://localhost:80/api/v1/view/all');
                const { error, all } = response.data;

                if (error === 'OK') {
                    setData(all);
                } else {
                    setError('Error fetching data');
                }
            } catch (error) {
                console.error('Unexpected error while fetching data', error);
                setError('Unexpected error while fetching data');
            }
        };

        fetchData();
    }, []);

    return (
        <div>
            <h1>View All Page</h1>
            {error && <p>{error}</p>}
            {data.map((item, index) => (
                <div key={index}>
                    <p>Old: {item.old}</p>
                    <p>New: {item.new}</p>
                    <p>Comment: {item.comment}</p>
                    <hr />
                </div>
            ))}
        </div>
    );
};

export default ViewAllPage;
