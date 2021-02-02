import { combineReducers } from 'redux';
import backlogReducer from './backlogReducer';
import errorReducer from './errorReducer';
import projectReducers from './projectReducers';

export default combineReducers({
    errors: errorReducer,
    project: projectReducers,
    backlog: backlogReducer
});