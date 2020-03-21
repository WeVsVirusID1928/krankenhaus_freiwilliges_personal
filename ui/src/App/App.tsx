import React, { FormEvent, useState, useEffect } from 'react';
import { usePostings } from './usePostings';

function App() {
  const [postThenGetPosting, postings, loading, error] = usePostings();

  const [title, setTitle] = useState('');
  const [time, setTime] = useState('');
  const [comment, setComment] = useState('');
  const [contact, setContact] = useState('');

  const handleSubmit = (event: FormEvent) => {
    event.preventDefault();

    postThenGetPosting({ title, time, comment, contact });
    setTitle('');
    setTime('');
    setContact('');
    setComment('');
  };

  if (loading) {
    return <p>loading...</p>;
  } else if (error) {
    return <p>❌ Failed to talk to backend</p>;
  }

  return (
    <>
      <form onSubmit={handleSubmit}>
        <input
          placeholder="Titel"
          value={title}
          onChange={event => setTitle(event.target.value)}
        />
        <input
          placeholder="Wann?"
          value={time}
          onChange={event => setTime(event.target.value)}
        />
        <input
          placeholder="Kommentar"
          value={comment}
          onChange={event => setComment(event.target.value)}
        />
        <input
          placeholder="Kontakt"
          value={contact}
          onChange={event => setContact(event.target.value)}
        />
        <button type="submit">Submit</button>
      </form>
      <h3>This is what the server said:</h3>
      <form></form>
      <ul>
        {postings?.map((posting: any) => {
          return (
            <li>
              <ul>
                <li>Titel: {posting.title}</li>
                <li>Zeit: {posting.time}</li>
                <li>Kommentar: {posting.comment}</li>
                <li>Kontakt: {posting.contact}</li>
              </ul>
            </li>
          );
        })}
      </ul>
    </>
  );
}

export default App;
