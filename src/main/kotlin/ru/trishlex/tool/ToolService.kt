package ru.trishlex.tool

import com.google.common.base.Suppliers
import org.springframework.stereotype.Service
import ru.trishlex.tool.model.ToolLight
import java.util.concurrent.TimeUnit

@Service
class ToolService(private val toolDao: ToolDao) {

    private val toolsCache = Suppliers.memoizeWithExpiration(
        { toolDao.getTools().sortedBy { it.id } },
        1,
        TimeUnit.HOURS
    )

    fun getTools(): List<ToolLight> {
        return toolsCache.get()
    }
}