import React, { useState } from 'react';

const App = () => {
  const [input, setInput] = useState('');
  const [shift, setShift] = useState(0);
  const [result, setResult] = useState('');
  const [errors, setErrors] = useState({});

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErrors({});
    setResult('');

    try {
      const response = await fetch("http://localhost:8080/api/shift", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ input, shift: Number(shift) }),
      });

      const data = await response.json();

      if (!response.ok) {
        setErrors(data.errors || { general: data.message || "Request failed" });
      } else {
        setResult(data.shifted);
      }
    } catch (error) {
      setErrors({ general: "Cannot connect to server. Is it running?" });
    }
  };

  return (
    <div style={{ padding: '20px', maxWidth: '400px', margin: '0 auto', fontFamily: 'Arial, sans-serif' }}>
      <h1 style={{ textAlign: 'center' }}>Shift App</h1>
      <form onSubmit={handleSubmit} style={{ display: 'grid', gap: '15px' }}>
        <div>
          <label>Input Text:</label>
          <input
            type="text"
            value={input}
            onChange={(e) => setInput(e.target.value)}
            style={{ width: '100%', padding: '8px', marginTop: '5px' }}
          />
          {errors.input && <p style={{ color: 'red', marginTop: '5px' }}>{errors.input}</p>}
        </div>
        <div>
          <label>Shift Amount:</label>
          <input
            type="number"
            value={shift}
            onChange={(e) => setShift(Number(e.target.value))}
            style={{ width: '100%', padding: '8px', marginTop: '5px' }}
          />
          {errors.shift && <p style={{ color: 'red', marginTop: '5px' }}>{errors.shift}</p>}
        </div>
        <button
          type="submit"
          style={{
            padding: '10px',
            backgroundColor: '#007BFF',
            color: 'white',
            border: 'none',
            borderRadius: '4px',
            cursor: 'pointer',
            width: '100%',
          }}
        >
          Shift Text
        </button>
        {errors.general && <p style={{ color: 'red', marginTop: '10px' }}>{errors.general}</p>}
      </form>

      {result && (
        <div style={{ marginTop: '20px' }}>
          <h2>Output:</h2>
          <pre style={{ whiteSpace: 'pre-wrap', padding: '10px', border: '1px solid #ccc', borderRadius: '4px' }}>
            {result}
          </pre>
        </div>
      )}
    </div>
  );
};

export default App;