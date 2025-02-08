using System;
using System.Diagnostics;

public class Calculadora
{
    public int Sumar(int a, int b)
    {
        return a + b;
    }
}

class Program
{
    static void Main()
    {
        Process currentProcess = Process.GetCurrentProcess();
        TimeSpan lastCpuTime = currentProcess.TotalProcessorTime;

        DateTimeOffset startTime1 = DateTimeOffset.UtcNow;
        long memoryUsage = currentProcess.WorkingSet64;

        //----------------------------------------------
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.Sumar(500, 500);
        Console.WriteLine($"El resultado de la suma es:  {resultado}");
        //----------------------------------------------

        DateTimeOffset endTime1 = DateTimeOffset.UtcNow;
        TimeSpan currentCpuTime = currentProcess.TotalProcessorTime;
        TimeSpan cpuUsage1 = currentCpuTime - lastCpuTime;
        double cpuUsagePercent = cpuUsage1.TotalMilliseconds / (Environment.ProcessorCount * 1000) * 100;
        lastCpuTime = currentCpuTime;
        Console.WriteLine($"Uso de CPU: {cpuUsagePercent:F2}%");
        Console.WriteLine($"Uso de memoria: {memoryUsage / 1024 / 1024} MB");        
        Console.WriteLine($"Tiempo transcurrido: {(endTime1 - startTime1).TotalMilliseconds} ms");

    }
}