import { McpServer } from "@modelcontextprotocol/sdk/server/mcp.js";
import { StdioServerTransport } from "@modelcontextprotocol/sdk/server/stdio.js";
import * as z from "zod";

const mcpServer = new McpServer({
  name: "my-first-mcp-server",
  version: "1.0.0"
});

mcpServer.registerTool("hello", {
  description: "Say hello to someone",
  inputSchema: z.object({
    name: z.string().describe("Name to greet")
  })
}, async ({ name }) => {
  const result = `Hello ${name}`;
  return {
    content: [
      {
        type: "text",
        text: result
      }
    ]
  };
});

async function main() {
  const transport = new StdioServerTransport();
  await mcpServer.connect(transport);
  console.log("MCP server is running...");
}

main().catch(error => {
  console.error("Server error:", error);
  process.exit(1);
});
