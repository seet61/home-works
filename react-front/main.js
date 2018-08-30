import React, {Component} from 'react';
import {render} from 'react-dom';
import * as style from './src/index.css';

function Square(props) {
    return (
        <button className={style.square} onClick={props.onClick}>
            {props.value}
        </button>
    );
}

function calculateWinner(squares) {
    const lines = [
        [0, 1, 2],
        [3, 4, 5],
        [6, 7, 8],
        [0, 3, 6],
        [1, 4, 7],
        [2, 5, 8],
        [0, 4, 8],
        [2, 4, 6],
    ];
    for (let i = 0; i < lines.length; i++) {
        const [a, b, c] = lines[i];
        if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
            return squares[a];
        }
    }
    return null;
}

class Board extends Component {
    constructor(props) {
        super(props);
        this.state = {
            squares: Array(9).fill(null),
            xIsNext: true,
        };
    }

    handleClick(i) {
        const squares = this.state.squares.slice();
        if (calculateWinner(squares) || squares[i]) {
            return;
        }
        squares[i] = this.state.xIsNext ? 'X' : 'O';
        this.setState({
            squares: squares,
            xIsNext: !this.state.xIsNext,
        });
    }

    renderSquare(i) {
        return (
            <Square
                value={this.state.squares[i]}
                onClick={() => this.handleClick(i)}
            />
        );
    }

    render() {
        const winner = calculateWinner(this.state.squares);
        let status;
        if (winner) {
            status = 'Победитель: ' + winner;
        } else {
            status = 'Ход игрока: ' + (this.state.xIsNext ? 'X' : 'O');
        }

        return (
            <div>
                <div className={style.status}>{status}</div>
                <div className={style.boardRow}>
                    {this.renderSquare(0)}
                    {this.renderSquare(1)}
                    {this.renderSquare(2)}
                </div>
                <div className={style.boardRow}>
                    {this.renderSquare(3)}
                    {this.renderSquare(4)}
                    {this.renderSquare(5)}
                </div>
                <div className={style.boardRow}>
                    {this.renderSquare(6)}
                    {this.renderSquare(7)}
                    {this.renderSquare(8)}
                </div>
                <button onClick={() => {
                    const squares = Array(9).fill(null);
                    this.setState({squares: squares});
                }
                }>Сброс</button>
            </div>
        );
    }
}

class Game extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div className={style.game}>
                <div className={style.gameBoard}>
                    <Board />
                </div>
            </div>
        );
    }
}

render(<Game />, document.getElementById('root'));
