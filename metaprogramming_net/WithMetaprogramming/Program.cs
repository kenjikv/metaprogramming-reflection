using System;
using System.Reflection;
using System.Reflection.Emit;
using System.Diagnostics;
class Program
{
  static void Main()
  {
    //----------------------------------------------
    Process currentProcess = Process.GetCurrentProcess();
    TimeSpan lastCpuTime = currentProcess.TotalProcessorTime;       
    DateTimeOffset startTime1 = DateTimeOffset.UtcNow;    
    long memoryUsage = currentProcess.WorkingSet64;
   
    AssemblyName assemblyCalculadora = new AssemblyName("DynamicAssemblyCalculator");
    AssemblyBuilder assemblyBuilder = AssemblyBuilder.DefineDynamicAssembly(
        assemblyCalculadora, 
        AssemblyBuilderAccess.Run);

    ModuleBuilder moduleCalculosBasicos = assemblyBuilder.DefineDynamicModule("ModuleCalculator");
    
    TypeBuilder typeCalculadora = moduleCalculosBasicos.DefineType(
        "Calculadora", 
        TypeAttributes.Public);

    MethodBuilder methodSumar = typeCalculadora.DefineMethod(
        "Sumar", 
        MethodAttributes.Public, 
        typeof(int), 
        new Type[] { typeof(int), typeof(int) }
        );   
    ILGenerator ilGenerator = methodSumar.GetILGenerator();
    ilGenerator.Emit(OpCodes.Ldarg_1);
    ilGenerator.Emit(OpCodes.Ldarg_2);
    ilGenerator.Emit(OpCodes.Add);
    ilGenerator.Emit(OpCodes.Ret);   

    Type calculadoraCreada = typeCalculadora.CreateType();
    object calculadora = Activator.CreateInstance(calculadoraCreada);
    MethodInfo metodoSumar = calculadoraCreada.GetMethod("Sumar");
    int resultado = (int)metodoSumar.Invoke(calculadora, new object[] { 500, 500 });

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