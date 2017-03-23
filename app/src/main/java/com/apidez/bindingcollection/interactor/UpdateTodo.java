package com.apidez.bindingcollection.interactor;

import com.apidez.bindingcollection.data.model.Todo;
import com.apidez.bindingcollection.data.repo.TodoRepo;
import com.apidez.bindingcollection.data.state.TodoListCollector;

import javax.inject.Inject;

import io.reactivex.Completable;

public class UpdateTodo {
    private final TodoRepo todoRepo;
    private final TodoListCollector todoListCollector;

    @Inject
    public UpdateTodo(TodoRepo todoRepo, TodoListCollector todoListCollector) {
        this.todoRepo = todoRepo;
        this.todoListCollector = todoListCollector;
    }

    public Completable execute(Todo todo) {
        return Completable.fromAction(() -> {
            todoRepo.updateTodo(todo);
            todoListCollector.update(todo);
        });
    }
}
