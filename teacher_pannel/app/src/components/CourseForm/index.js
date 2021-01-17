import React, { useState } from 'react';

const CourseForm = ({ createNew, cancel }) => {
    const [name, setName] = useState("");
    const [desc, setDesc] = useState("");
    const submit = (e) => {
        e.preventDefault();
        createNew(name, desc);
    }
    const hideForm = (e) => {
        e.preventDefault();
        cancel();
    }
    return (
        <div style={{marginBottom:'50px'}}>
            <form style={{ display: 'flex', flexDirection: 'column' }}>
                <label htmlFor="name">Nazwa kursu:</label>
                <input id="name" onChange={e => setName(e.target.value)} />
                <label htmlFor="description">Opis kursu</label>
                <textarea id="description" rows={3} onChange={e => setDesc(e.target.value)} />
                <div style={{display:'flex'}}>
                    <input type="submit" value="Stwórz" onClick={submit} />
                    <button onClick={hideForm}>Anuluj</button>
                </div>
            </form>
        </div>
    );
}

export default CourseForm;