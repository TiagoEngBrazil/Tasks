package com.devmasterteam.tasks.service.repository


import android.content.Context
import com.devmasterteam.tasks.service.listener.APIListener
import com.devmasterteam.tasks.service.model.TaskModel
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient
import com.devmasterteam.tasks.service.repository.remote.TaskService

class TaskRepository(context: Context) : BaseRepository(context) {

    private val remote = RetrofitClient.getService(TaskService::class.java)


    fun list(listener: APIListener<List<TaskModel>>) {
        executeCall(remote.list(), listener)
    }


    fun listNext(listener: APIListener<List<TaskModel>>) {
        executeCall(remote.listNext(), listener)
    }

    fun listOverdue(listener: APIListener<List<TaskModel>>) {
        executeCall(remote.listOverdue(), listener)
    }

    fun create(task: TaskModel, listener: APIListener<Boolean>) {
        val call = remote.create(task.priorityId, task.description, task.dueDate, task.complete)
        executeCall(call, listener)
    }

    fun update(task: TaskModel, listener: APIListener<Boolean>) {
        val call =
            remote.update(task.id, task.priorityId, task.description, task.dueDate, task.complete)
        executeCall(call, listener)
    }

    fun load(id: Int, listener: APIListener<TaskModel>) {
        executeCall(remote.load(id), listener)
    }

    fun delete(id: Int, listener: APIListener<Boolean>) {
        executeCall(remote.delete(id), listener)
    }

    fun complete(id: Int, listener: APIListener<Boolean>) {
        executeCall(remote.complete(id), listener)
    }

    fun undo(id: Int, listener: APIListener<Boolean>) {
        executeCall(remote.undo(id), listener)
    }

}